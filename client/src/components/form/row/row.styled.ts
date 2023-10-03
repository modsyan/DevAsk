import styled, { css } from 'styled-components';
interface StyledFormRowProps {
  dir?: 'row' | 'col';
}
const directions = {
  row: css`
    display: grid;
    align-items: center;
    grid-template-columns: 24rem 1fr 1.2fr;
    gap: 2.4rem;
    padding: 1.2rem 0;

    &:first-child {
      padding-top: 0;
    }

    &:last-child {
      padding-bottom: 0;
    }

    &:not(:last-child) {
      border-bottom: 1px solid var(--color-grey-100);
    }

    &:has(button) {
      display: flex;
      justify-content: flex-end;
      gap: 1.2rem;
    }
  `,
  col: css`
    display: flex;
    flex-direction: column;
    gap: 0.8rem;
    padding: 1.2rem 0;
  `,
};
export const StyledFormRow = styled.div<StyledFormRowProps>`
  ${(props) => directions[props.dir ?? 'col']}
`;

export const Label = styled.label`
  font-weight: 500;
`;

export const Error = styled.span`
  font-size: 1.4rem;
  color: var(--color-red-700);
`;
