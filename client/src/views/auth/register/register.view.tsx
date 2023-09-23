import { ENDPOINT_CONFIGS } from '@constants/endpoints';
import { Button, Input } from '@components';
import { FormEvent, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

import { RegisterForm } from '@features/auth';
import { BaseLayout } from '@layouts/base';

type Props = {};

export const Register: React.FC<Props> = () => {
  return (
    <BaseLayout>
      <RegisterForm />
    </BaseLayout>
  );
};
