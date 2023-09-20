import { AuthButtons } from './AuthButtons';
import { Logo } from './Logo';
import { NavLinks } from './NavLinks';

export const NavBar = () => {
  return (
    <>
      <nav className="flex justify-between items-center py-2 px-3">
        <Logo />
        <NavLinks />
        <AuthButtons />
      </nav>
    </>
  );
};
