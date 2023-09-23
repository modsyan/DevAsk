import { Link } from 'react-router-dom';
import { Button } from '@components';
import './auth-buttons.styled';
import { StyledDiv } from './auth-buttons.styled';

export const AuthButtons = () => {
  return (
    <StyledDiv>
      <div className="flex gap-3">
        <Link to={'/login'}>
          <Button label="Login" variant="ghost" size="sm" />
        </Link>

        <Link to={'/register'}>
          <Button label="Register" variant="solid" size="sm" />
        </Link>
      </div>
    </StyledDiv>
  );
};
