import { FormRow, StyledButton, StyledInputV2 } from '@components';
import { Form } from '@components';
import { Link } from 'react-router-dom';
// import { useLogin } from './useLogin';
import { useForm, SubmitHandler } from 'react-hook-form';
import { DevTool } from '@hookform/devtools';
// import { loginApi } from './api.login';
type Inputs = {
  // all of these fields are required
  loginIdentifier: string;
  password: string;
};
export const LoginFormV2 = () => {
  const { register, control, handleSubmit } = useForm<Inputs>();

  const onSubmit: SubmitHandler<Inputs> = (data) => console.log(data);
  // loginApi(getValues().loginIdentifier, getValues().password);
  return (
    <>
      <Form onSubmit={handleSubmit(onSubmit)}>
        <FormRow label="Username/Email">
          <StyledInputV2
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
        </FormRow>

        <FormRow label="Password">
          <StyledInputV2
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
        </FormRow>
        <FormRow>
          <StyledButton>Login</StyledButton>
        </FormRow>
        <FormRow>
          <span>
            don't have an account?{' '}
            <Link to={'/register'} className="text-brand-200">
              Register Now
            </Link>
          </span>
        </FormRow>
      </Form>
      <DevTool control={control} />
    </>
  );
};
