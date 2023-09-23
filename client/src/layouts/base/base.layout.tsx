import { Footer, NavBar } from '@components';
import * as Styled from './base.styled';

interface Props {
  children: React.ReactNode;
}

export const BaseLayout: React.FC<Props> = (props: Props) => {
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
