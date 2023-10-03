import { QuestionBox } from '../QuestionBox';
import { NotFound, Spinner } from '@components';
import { useQuestions } from './useQuestions';
// import { SkeletonLoading } from './skeleton-loading/skeleton-loading.component';

interface Props {}

export const Feed: React.FC<Props> = () => {
  const { questions, isLoading, isError } = useQuestions();

  return (
    <div className="flex flex-col gap-1 bg-brand-600">
      {
        isLoading && <Spinner />
        // <SkeletonLoading />
      }

      {isError && (
        <div className="from-brand-300 to-brand-500 transition-opacity ease-in duration-700 opacity-25">
          <NotFound />
        </div>
      )}

      {!isLoading &&
        !isError &&
        questions.map((q) => (
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

