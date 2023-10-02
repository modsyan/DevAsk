import { Button, FormRowVertical, Input } from '@components';
import { Form } from '@components';
import { Link } from 'react-router-dom';
import styled from 'styled-components';
import { useForm } from 'react-hook-form';
import { DevTool } from '@hookform/devtools';
// import { useMutation } from 'react-query';
// import { registerUser } from './api.register.ts.off';
// import { useLogin } from './useLogin';
const Temp = styled.div`
  display: grid;
  grid-template-columns: repeat(2, 1fr);
  gap: 1.2rem;
`;
type Inputs = {
  firstName: string;
  lastName: string;
  email: string;
  username: string;
  password: string;
  confirmPassword: string;
  bio: string;
};
export const RegisterForm = () => {
  const {
    register,
    control,
    handleSubmit,
    formState: errors,
    getValues,
    reset,
  } = useForm<Inputs>({
    defaultValues: {
      firstName: '',
      lastName: '',
      username: '',
      password: '',
      confirmPassword: '',
      bio: '',
    },
  });
  const onSubmit = () => {};
  return (
    <Form type="regular" onSubmit={handleSubmit(onSubmit)}>
      <Temp>
        <FormRowVertical label="First Name">
          <Input type="text"></Input>
        </FormRowVertical>
        <FormRowVertical label="Last Name">
          <Input type="text"></Input>
        </FormRowVertical>
      </Temp>
      <FormRowVertical label="Email address">
        <Input
          type="email"
          id="email"
          // This makes this form better for password managers
          autoComplete="email"
          // value={email}
          // onChange={(e: any) => setEmail(e.target.value)}
        />
      </FormRowVertical>
      <FormRowVertical label="Username">
        <Input
          type="email"
          id="email"
          // This makes this form better for password managers
          autoComplete="username"
          // value={email}
          // onChange={(e: any) => setEmail(e.target.value)}
        />
      </FormRowVertical>
      <FormRowVertical label="Password">
        <Input type="password" id="password" autoComplete="current-password" />
      </FormRowVertical>
      <FormRowVertical label="Confirm Password">
        <Input type="password" id="password" autoComplete="current-password" />
      </FormRowVertical>
      <FormRowVertical>
        <Button>Register</Button>
      </FormRowVertical>
      <FormRowVertical>
        <span>
          already have an account?{' '}
          <Link to={'/login'} className="text-brand-200">
            Login
          </Link>
        </span>
      </FormRowVertical>

      <DevTool control={control} />
    </Form>
  );
};
