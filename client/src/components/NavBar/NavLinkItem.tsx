import { Link } from 'react-router-dom';

export const NavLinkItem = (props: { label: string; route: string }) => {
  return (
    <>
      <li
        className={[
          'text-brand-100',
          'hover:bg-brand-800',
          'py-2',
          'px-4',
          'hover:rounded-md',
          'transition-all',
          'ease-in-out',
          'duration-150',
        ].join(' ')}
      >
        <Link to={props.route}>{props.label}</Link>
      </li>
    </>
  );
};
