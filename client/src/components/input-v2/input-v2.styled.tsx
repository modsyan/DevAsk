import styled from 'styled-components';

export const StyledInputV2 = styled.input`
  background-color: transparent;
  // border-radius: var(--border-radius-sm);
  border-bottom: 1px solid white;
  padding: 0.8rem 1.4rem;
  box-shadow: var(--shadow-sm);
  color: var(--color-grey-200);
  &:focus {
    border-bottom: 1px solid var(--color-brand-100);
  }
`;
