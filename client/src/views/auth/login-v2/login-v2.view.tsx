import { LoginFormV2 } from '@features/auth';
import styled from 'styled-components';
const LoginLayout = styled.main`
  display: grid;
  grid-template-columns: 52rem;
  min-height: 100vh;
  width: 100%;
  align-items: center;
  justify-content: center;

  background-color: var(--color-grey-900);
`;
export const LoginV2 = () => {
  return (
    <LoginLayout>
      <LoginFormV2 />
    </LoginLayout>
  );
};
