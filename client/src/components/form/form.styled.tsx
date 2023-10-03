import styled, { css } from 'styled-components';

export interface FormProps extends React.HTMLProps<HTMLFormElement> {
  type?: 'regular' | 'modal';
}

export const Form = styled.form<FormProps>`
  ${(props) =>
    props.type === 'regular' &&
    css`
      padding: 2.4rem 4rem;

      /* Box */
      background-color: var(--color-grey-800);
      // border: 1px solid var(--color-grey-100);
      border-radius: var(--border-radius-md);
      color: var(--color-grey-500);
    `}

  ${(props) =>
    props.type === 'modal' &&
    css`
      width: 80rem;
    `}
    
  overflow: hidden;
  font-size: 1.4rem;
`;

Form.defaultProps = {
  type: 'regular',
};
