import { AuthButtons } from './auth-buttons';
import { Logo } from './logo';
import { NavbarLinks } from './links';
import { StyledDiv } from './navbar.styled';

export const NavBar = () => {
  return (
    <>
      <StyledDiv>
        <div className="flex justify-between items-center py-2 px-3">
          <Logo />
          <NavbarLinks />
          <AuthButtons />
        </div>
      </StyledDiv>
    </>
  );
};
