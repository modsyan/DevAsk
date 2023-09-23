import { Link } from 'react-router-dom';
import './item.styled';
import { StyledDiv } from './item.styled';

export const NavbarLinksItem = (props: { label: string; route: string }) => {
  return (
    <>
      <StyledDiv>
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
      </StyledDiv>
    </>
  );
};
