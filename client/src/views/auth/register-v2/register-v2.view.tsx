import { RegisterFormV2 } from '@features/auth';
import styled from 'styled-components';
const RegisterLayout = styled.main`
  min-height: 100vh;
  display: grid;
  grid-template-columns: 60rem;
  align-content: center;
  justify-content: center;
  gap: 3.2rem;
  background-color: var(--color-grey-900);
`;

export const RegisterV2 = () => {
  return (
    <>
      <RegisterLayout>
        <RegisterFormV2 />
      </RegisterLayout>
    </>
  );
};
