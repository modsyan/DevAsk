import { useQuery } from 'react-query';
import { axiosClient } from '../utils/axiosClient';
import { ENDPOINT_CONFIGS } from '@constants/endpoints';

export const useGetUser = (userId: string | number) => {
  const {
    isLoading,
    isError,
    data: user,
  } = useQuery(
    [`user-${userId}`],
    async () => {
      const getUserByIdWithParamsConfig = ENDPOINT_CONFIGS.getUserById;
      getUserByIdWithParamsConfig.url =
        getUserByIdWithParamsConfig.url + userId;
      const res = await axiosClient(getUserByIdWithParamsConfig);
      return res.data;
    },
    { retry: false }
  );
  return { isError, isLoading, user };
};
