import { useQuery } from 'react-query';
import { axiosClient } from '../../../utils/axiosClient';
import { Question } from '../QuestionBox';
import { ENDPOINT_CONFIGS } from '@constants/endpoints';

export const useQuestions = () => {
  const {
    isLoading,
    isError,
    data: questions,
  } = useQuery([`questions`], async () => {
    const res = await axiosClient(ENDPOINT_CONFIGS.getQuestions);

    console.log(res.data);

    return res.data.data;
  });
  return { isError, isLoading, questions: questions as Question[] };
};
