import { WelcomeCard } from './welcome-card';

import * as Styled from './Landing.styled';

export const Landing = () => {
  return (
    <Styled.Div>
      <div className="min-h-screen bg-brand-900">
        <WelcomeCard />
      </div>
    </Styled.Div>
  );
};
