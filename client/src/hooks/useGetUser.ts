import { useQuery } from 'react-query';
import axiosClient from '../utils/axiosClient';

export const useGetUser = (userId: string | number) => {
  const {
    isLoading,
    isError,
    data: user,
  } = useQuery(
    [`user-${userId}`],
    async () => {
      const res = await axiosClient.get(`/users/${userId}`);
      return res.data;
    },
    { retry: false }
  );
  return { isError, isLoading, user };
};
