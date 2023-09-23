import { ENDPOINT_CONFIGS } from '@constants/endpoints';
import { Button, Input } from '@components';
import { FormEvent, useState } from 'react';
import { Link } from 'react-router-dom';
import axios from 'axios';

import * as styled from './register.styled';

type Props = {};

export const Register: React.FC<Props> = () => {
  useState({});
  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault();

    try {
      const response = await axios.post(ENDPOINT_CONFIGS.register.url);
      console.log(response.data);
    } catch (error) {
      console.error(error);
    }
  };
  const state = useState();
  return (
    <styled.BodyWrapper>
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
              <h1 className="text-[22px] font-bold text-brand-50">Register</h1>
            </div>
            <div className="flex flex-col gap-5">
              <Input id="username" label="Username" />
              <Input id="email" label="Email" />
              <Input id="password" label="Password" />
              <Input id="bio" label="Bio" />
            </div>
            <div className="flex items-center gap-4">
              <Button
                label="Register"
                variant="solid"
                onClick={handleSubmit}
                size="md"
              />
              <p className="text-zinc-50">
                Already have an account?{' '}
                <Link to="/login">
                  <span className="text-brand-50">Login</span>
                </Link>
              </p>
            </div>
          </div>
        </div>
      </div>
    </styled.BodyWrapper>
  );
};
