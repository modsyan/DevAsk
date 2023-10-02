import { AskQuestionForm } from '@features/questions/ask/AskQuestionForm';
export const AskQuestion = () => {
  return (
    <>
      <div className="bg-brand-900 h-screen w-full flex flex-col bg-gradient-to-l from-brand-700 via-brand-900">
        <AskQuestionForm />
      </div>
    </>
  );
};
