import { LoginForm } from '@features/auth';
import { BaseLayout } from '@layouts/base';

type Props = {};

export const Login: React.FC<Props> = () => {
  return (
    <BaseLayout>
      <LoginForm />
    </BaseLayout>
  );
};
