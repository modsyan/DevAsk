import { EndpointConfig } from '@constants/endpoints';
import axios, { AxiosRequestConfig } from 'axios';

export const axiosClient = async (endpoint: EndpointConfig) => {
  let request: AxiosRequestConfig = {
    method: endpoint.method.toUpperCase(),
    baseURL: endpoint.url,
  };

  if (endpoint.auth) {
    request = {
      ...request,
      headers: {
        Authorization:
          'Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2RjbG92ZXI3QGdtYWlsLmNvbSIsImlhdCI6MTY5NTk0NjU3NiwiZXhwIjoxNjk2MDMyOTc2fQ.wnazWRPOCwDge_MoPCS06hPAmMvyWU7YnU9h5X2u7yA',
      },
    };
  }

  return axios.request(request);
};
