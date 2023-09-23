import { NavbarLinksItem } from './item';
import './links.styled';
import { StyledDiv } from './links.styled';

export const NavbarLinks = () => {
  return (
    <>
      <StyledDiv>
        <ul
          className={[
            'flex',
            'justify-between',
            'items-center',
            'gap-6',
            '',
          ].join(' ')}
        >
          <NavbarLinksItem label="Home" route="/" />
          <NavbarLinksItem label="About" route="/" />
          <NavbarLinksItem label="Support" route="/" />
          <NavbarLinksItem label="Contact" route="/" />
        </ul>
      </StyledDiv>
    </>
  );
};
