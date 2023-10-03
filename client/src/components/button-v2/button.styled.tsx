import styled, { css, DefaultTheme } from 'styled-components';

const sizes: Record<string, ReturnType<typeof css>> = {
  small: css`
    font-size: 1.4rem;
    padding: 0.5rem 0.8rem;
    text-transform: uppercase;
    font-weight: 600;
    text-align: center;
  `,
  medium: css`
    font-size: 1.6rem;
    padding: 1.2rem 1.6rem;
    font-weight: 500;
  `,
  large: css`
    font-size: 1.8rem;
    padding: 1.2rem 2.4rem;
    font-weight: 500;
  `,
};

const variations: Record<string, ReturnType<typeof css>> = {
  primary: css`
    color: var(--color-brand-50);
    background-color: var(--color-grey-200);
    box-shadow: var(--shadow-sm);
    &:hover {
      background-color: var(--color-brand-200);
      color: var(--color-grey-50);
    }
  `,
  secondary: css`
    color: var(--color-grey-600);
    background: var(--color-grey-0);
    border: 1px solid var(--color-grey-200);

    &:hover {
      background-color: var(--color-grey-50);
    }
  `,
  danger: css`
    color: var(--color-red-100);
    background-color: var(--color-red-700);

    &:hover {
      background-color: var(--color-red-800);
    }
  `,
};

export interface StyledButtonProps {
  variation?: 'primary' | 'secondary' | 'danger';
  size?: 'small' | 'medium' | 'large';
}

export const StyledButton = styled.button<StyledButtonProps>`
  border: none;
  border-radius: var(--border-radius-sm);
  box-shadow: var(--shadow-sm);

  ${(props: StyledButtonProps) => sizes[props.size || 'medium']}
  ${(props: StyledButtonProps) => variations[props.variation || 'primary']}
`;

StyledButton.defaultProps = {
  variation: 'primary',
  size: 'medium',
};
