import { ENDPOINT_CONFIGS } from '@constants/endpoints';
import { Button, Input } from '@components';
import { Link } from 'react-router-dom';
import { FormEvent } from 'react';
import axios from 'axios';

import * as styled from './login.styled';

type Props = {};

export const Login: React.FC<Props> = () => {

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();
    try {
      const response = await axios.post(ENDPOINT_CONFIGS.login.url);
    } catch (error) {}
  };

  return (
    <styled.Div>
      <div
        className={[
          'bg-brand-900',
          'h-screen',
          'w-full',
          'flex',
          'flex-col',
          'justify-center',
          'items-center',
          'bg-gradient-to-l',
          'from-brand-700',
          'via-brand-900',
        ].join(' ')}
      >
        <div>
          <div
            className={[
              'box',
              'flex',
              'flex-col',
              'gap-8',
              'w-full',
              'justify-center',
            ].join(' ')}
          >
            <div className="title">
              <h1 className="text-[22px] font-bold text-brand-50">Login</h1>
            </div>
            <div className="flex flex-col gap-5">
              <Input id="username" label="Username of Email" />
              <Input id="password" label="Password" />
            </div>
            <div className="flex items-center gap-4">
              <Button
                label="Login"
                variant="solid"
                onClick={handleSubmit}
                size="md"
              />
              <p className="text-zinc-50">
                Don't have an account?{' '}
                <Link to={'/register'}>
                  <span className="text-brand-50">Create One</span>
                </Link>
              </p>
            </div>
          </div>
        </div>
      </div>
    </styled.Div>
  );
};
