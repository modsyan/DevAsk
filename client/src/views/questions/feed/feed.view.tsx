import Question from '@features/questions';
import { BaseLayout } from '@layouts/base';

export type WrapperProps = {
  mainApp: React.ElementType;
};

export const Feed : React.FC = () => {
  return (
    <BaseLayout>
      <Question.Feed />
    </BaseLayout>
  );
};
