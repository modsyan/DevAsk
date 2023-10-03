import { FormRow, Input, StyledButton, StyledInputV2 } from '@components';
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
export const RegisterFormV2 = () => {
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
        <FormRow label="First Name">
          <StyledInputV2 type="text"></StyledInputV2>
        </FormRow>
        <FormRow label="Last Name">
          <StyledInputV2 type="text"></StyledInputV2>
        </FormRow>
      </Temp>
      <FormRow label="Email address">
        <StyledInputV2
          type="email"
          id="email"
          // This makes this form better for password managers
          autoComplete="email"
          // value={email}
          // onChange={(e: any) => setEmail(e.target.value)}
        />
      </FormRow>
      <FormRow label="Username">
        <StyledInputV2
          type="email"
          id="email"
          // This makes this form better for password managers
          autoComplete="username"
          // value={email}
          // onChange={(e: any) => setEmail(e.target.value)}
        />
      </FormRow>
      <FormRow label="Password">
        <StyledInputV2
          type="password"
          id="password"
          autoComplete="current-password"
        />
      </FormRow>
      <FormRow label="Confirm Password">
        <StyledInputV2
          type="password"
          id="password"
          autoComplete="current-password"
        />
      </FormRow>
      <FormRow>
        <StyledButton>Register</StyledButton>
      </FormRow>
      <FormRow>
        <span>
          already have an account?{' '}
          <Link to={'/login'} className="text-brand-200">
            Login
          </Link>
        </span>
      </FormRow>

      <DevTool control={control} />
    </Form>
  );
};
