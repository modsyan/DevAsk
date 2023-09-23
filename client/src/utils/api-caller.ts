import { EndpointConfig } from '../constants/endpoints';

export const ApiCaller = (endpoints: EndpointConfig) => {
  // auth
  // post | get | patch | delete
  // route

  // ax1;
};

export function AddQueryParam(endpoint: EndpointConfig, ...params: string[]) {
  let baseUrl: string = endpoint.url;

  // for (let )

  return {
    url: baseUrl,
    auth: endpoint.auth,
    method: endpoint.method,
  } as EndpointConfig;
}

export function AddQueryString(
  endpoint: EndpointConfig,
  ...params: Map<string, string | number>[]
) {
  let baseUrl: string = endpoint.url;

  // adding queryStringToUrl


  return {
    url: baseUrl,
    auth: endpoint.auth,
    method: endpoint.method,
  } as EndpointConfig;
}
