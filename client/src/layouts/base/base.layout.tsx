import { Footer, NavBar } from '@components';
import * as Styled from './base.styled';

interface Props {
  children: React.ReactNode;
}

export const BaseLayout: React.FC<Props> = (props: Props) => {
  return (
    <>
      <Styled.StyledDiv>
        <div className="min-h-screen bg-brand-900">
            {/* <div className="mx-24">
              <NavBar />
            </div> */}
          <main>{props.children}</main>
          <Footer />
        </div>
      </Styled.StyledDiv>
    </>
  );
};
