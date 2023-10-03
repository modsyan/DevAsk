import { Error, Label, StyledFormRow } from './row.styled';

interface FormRowProps {
  label?: string;
  error?: string;
  children: React.ReactNode;
}

export const FormRow: React.FC<FormRowProps> = ({ label, error, children }) => {
  return (
    <StyledFormRow>
      {label && <Label htmlFor={label}>{label}</Label>}
      {children}
      {error && <Error>{error}</Error>}
    </StyledFormRow>
  );
};
