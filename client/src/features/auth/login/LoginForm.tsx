import { useState } from 'react';
import { Button, FormRowVertical, Input } from '@components';
import { Form } from '@components';
import { Link } from 'react-router-dom';
// import { useLogin } from './useLogin';
import { useForm, SubmitHandler } from 'react-hook-form';
import { DevTool } from '@hookform/devtools';
type Inputs = {
  // all of these fields are required
  loginIdentifier: string;
  password: string;
};
export const LoginForm = () => {
  const { register, control, handleSubmit } = useForm<Inputs>();
  const onSubmit: SubmitHandler<Inputs> = (data) => console.log(data);
  register('loginIdentifier', {
    required: {
      value: true,
      message: `This field is required`,
    },
  });
  register('password', {
    required: {
      value: true,
      message: `This field is required`,
    },
  });
  return (
    <>
      <Form type="regular" onSubmit={handleSubmit(onSubmit)}>
        <FormRowVertical label="Username/Email">
          <Input
            type="email"
            id="loginIdentifier"
            // This makes this form better for password managers
            autoComplete="username"
            // value={email}
            // onChange={(e: any) => setEmail(e.target.value)}
            {...register('loginIdentifier', {
              required: { value: true, message: 'this field is required' },
            })}
          />
        </FormRowVertical>

        <FormRowVertical label="Password">
          <Input
            type="password"
            id="Password"
            autoComplete="current-password"
            // value={password}
            {...register('password', {
              required: {
                value: true,
                message: 'This field is required',
              },
            })}
          />
        </FormRowVertical>
        <FormRowVertical>
          <Button>Login</Button>
        </FormRowVertical>
        <FormRowVertical>
          <span>
            don't have an account?{' '}
            <Link to={'/register'} className="text-brand-200">
              Register Now
            </Link>
          </span>
        </FormRowVertical>
      </Form>
      <DevTool control={control} />
    </>
  );
};
