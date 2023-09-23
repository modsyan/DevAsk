import { Link } from 'react-router-dom';
import { StyledDiv } from './section.styled';

export const Section = (props: {
  title: string;
  elements: { route: string; name: string }[];
}) => {
  return (
    <StyledDiv>
      <div className={['flex', 'flex-col', 'gap-2', 'h-full'].join(' ')}>
        <h1 className={['font-bold', 'text-brand-300'].join(' ')}>
          {props.title}
        </h1>
        <div
          className={['flex', 'flex-col', 'gap-2', 'text-zinc-100'].join(' ')}
        >
          {props.elements.map((e) => {
            return <Link to={e.route}>{e.name}</Link>;
          })}
        </div>
      </div>
    </StyledDiv>
  );
};
