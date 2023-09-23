import { Footer, NavBar } from '@components';
import * as Styled from './dashboard.styled';

interface Props {
  children: React.ReactNode;
}

export const DashBoardLayout: React.FC<Props> = (props: Props) => {
  return (
    <>
      <Styled.BodyWrapper>
        <NavBar />
        <main>{props.children}</main>
        <Footer />
      </Styled.BodyWrapper>
    </>
  );
};
