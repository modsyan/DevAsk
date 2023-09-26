import { useQuery } from 'react-query';
import axiosClient from '../../../utils/axiosClient';
import { Question, QuestionBox } from '../QuestionBox';
const useQuestions = () => {
  const {
    isLoading,
    isError,
    data: questions,
  } = useQuery([`questions`], async () => {
    const res = await axiosClient.get(`/questions/`);
    console.log(res.data.data);

    return res.data.data;
  });
  return { isError, isLoading, questions: questions as Question[] };
};

export const Feed = () => {
  // extract string queries
  const { questions, isLoading, isError } = useQuestions();
  // console.log('data');

  if (isLoading) return <span>Loading ...</span>;
  if (isError) return <span>Can not fetch data ..</span>;
  return (
    <div className="flex flex-col gap-1 bg-brand-600">
      {questions.map((q) => (
        <QuestionBox
          question={q}
          key={q.id}
          state="feed"
          className={`w-[70%] m-auto rounded-lg mt-4`}
        />
      ))}
    </div>
  );
};
