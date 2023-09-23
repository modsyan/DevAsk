import { Link } from 'react-router-dom';
import { StyledDiv } from './logo.styled';

export const Logo = () => {
  return (
    <>
      <StyledDiv>
        <Link to={'/'}>
          <h1 className={['text-zinc-300', 'font-extrabold'].join(' ')}>
            DevAsk
          </h1>
        </Link>
      </StyledDiv>
    </>
  );
};
