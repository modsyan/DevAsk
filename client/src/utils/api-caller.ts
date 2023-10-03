import { ApiError } from 'src/models/api-error';
import { EndpointConfig } from '../constants/endpoints';
import { QueryClient } from '@tanstack/react-query';
import axios, { AxiosInstance, AxiosRequestConfig } from 'axios';

// export const ApiCaller = (endpoints: EndpointConfig) => {
//   // auth
//   // post | get | patch | delete
//   // route
//   // ax1;
// };

// export function AddQueryParam(endpoint: EndpointConfig, ...params: string[]) {
//   let baseUrl: string = endpoint.url;

//   for (let i = 0; i < params.length; i++){
//     baseUrl = baseUrl.replace()
//   }

//   return {
//     url: baseUrl,
//     auth: endpoint.auth,
//     method: endpoint.method,
//   } as EndpointConfig;
// }

interface RetryConfig {
  retry: number;
  retryDelay: number;
}

// export function withParams(
//   endpoint: EndpointConfig,
//   ...params: string[]
// ): EndpointConfig {
//   let url = endpoint.url;
//   const placeholders = url.match(/:[^\/]*/g) || [];
//   if (placeholders.length !== params.length) {
//     throw `Too ${
//       placeholders.length < params.length ? 'many' : 'few'
//     } params for url: ${url}!`;
//   }
//   for (let index = 0; index < params.length; index++) {
//     url = url.replace(placeholders[index], params[index]);
//   }
//   return {
//     url: url,
//     method: endpoint.method,
//     auth: endpoint.auth,
//   } as EndpointConfig;
// }

// export function AddQueryString(
//   endpoint: EndpointConfig,
//   ...params: Map<string, string | number>[]
// ) {
//   let baseUrl: string = endpoint.url;

//   // adding queryStringToUrl

//   return {
//     url: baseUrl,
//     auth: endpoint.auth,
//     method: endpoint.method,
//   } as EndpointConfig;
// }

// {{ UserAuth}}  ------------------>>>>>>>>>>>>>>>>>
const isLoggedIn = () => {
  return true;
};
const signOut = () => {};
const getLocalStorageToken = () => {};
// {{ UserAuth}}  ------------------>>>>>>>>>>>>>>>>>

export const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      networkMode: 'offlineFirst',
      retry(failureCount, error) {
        const { status } = error as ApiError;
        if (typeof status !== 'number') {
          console.error('got non numeric error code: ', error);
          return true;
        }
        return status >= 500 && failureCount < 2;
      },
    },
  },
});

export const callEndpoint = async <Request, Response>(
  { auth, method, url }: EndpointConfig,
  request?: Request
) => {
  const requestBody = request ? JSON.stringify(request) : undefined;

  const requestConfig: AxiosRequestConfig = {
    method: method.toUpperCase(),
    baseURL: url,
    headers: {
      'Content-Type': 'application/json',
      Accept: 'application/json',
      ...((auth || isLoggedIn()) && {
        Authorization: `Bearer ${getLocalStorageToken()}`,
      }),
    },
    data: requestBody,
  };

  const retryRequestConfig: RetryConfig = {
    retry: 3,
    retryDelay: 3000,
  };

  const responseInstance: AxiosInstance = axios.create(requestConfig);

  responseInstance.interceptors.response.use(
    async (response) => {
      if (response.status >= 200 || response.status <= 226) {
        return response.data;
      }
      signOut();
      window.location.reload();
      throw new ApiError(response.status, response.data.message);
    },

    async (error) => {
      const { config } = error;
      if (!config || !retryRequestConfig.retry) {
        return Promise.reject(error);
      }

      config.retry--;

      return new Promise<void>((resolve) => {
        setTimeout(() => {
          resolve();
        }, retryRequestConfig.retryDelay || 1000);
      }).then(() => responseInstance(config));
    }
  );

  const response = await responseInstance.request<Response>(requestConfig);

  return response;
};
