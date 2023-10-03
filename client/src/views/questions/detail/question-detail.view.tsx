import Questions from '@features/questions';
import { useParams } from 'react-router-dom';

interface Props {
  questionId: string;
}

export const QuestionDetails: React.FC = (props) => {

  const { id } = useParams<string>();
  console.error(id);
  return (
    <>
      <Questions.Detail id={id!} />
    </>
  );
};
