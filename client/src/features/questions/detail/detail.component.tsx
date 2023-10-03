import { useQuery } from 'react-query';
import {axiosClient} from '../../../utils/axiosClient';
import { Question, QuestionBox } from '../QuestionBox';
import { useParams } from 'react-router-dom';
import { Divider } from '@components';
import { BaseLayout } from '@layouts/base';
import { ENDPOINT_CONFIGS } from '@constants/endpoints';

const useQuestion = (questionId: string) => {
  const {
    isLoading,
    isError,
    data: question,
  } = useQuery([`question-${questionId}`], async () => {
    const res = await axiosClient(ENDPOINT_CONFIGS.getQuestionDetail);
    return res.data.data;
  });
  return { isError, isLoading, question: question as Question };
};
export const QuestionDetails = (params: {id: string}) => {
  // const { id } = useParams();

  const { question, isLoading, isError } = useQuestion(params.id!);

  if (isLoading) return <h1>Loading ... </h1>;
  if (isError) return <h1>Error</h1>;
  return (
    <>
      <BaseLayout>
        <div className="bg-brand-700 min-h-screen w-full">
          <Divider />
          <QuestionBox question={question} state="details" className="p-24" />
          <Divider />

          <div className="mt-4 mx-32 p-16 flex flex-col gap-8">
            <h1 className="text-3xl uppercase font-extrabold text-zinc-100 mt-">
              Solutions
            </h1>
            <QuestionBox
              question={question}
              state="details"
              className="p-16 rounded-xl bg-green-800"
            />
            <QuestionBox
              question={question}
              state="details"
              className="p-16 rounded-xl bg-green-800"
            />
          </div>
        </div>
      </BaseLayout>
    </>
  );
};
