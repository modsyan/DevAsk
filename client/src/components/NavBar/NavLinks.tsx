import { NavLinkItem } from "./NavLinkItem";

export const NavLinks = () => {
  return (
    <>
      <ul
        className={['flex', 'justify-between', 'items-center', 'gap-6'].join(' ')}
      >
        <NavLinkItem label="Home" route="/"/>
        <NavLinkItem label="About" route="/"/>
        <NavLinkItem label="Support" route="/"/>
        <NavLinkItem label="Contact" route="/"/>
      </ul>
    </>
  );
};
