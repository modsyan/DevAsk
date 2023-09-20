import { Footer } from '../../components/Footer';
import { NavBar } from '../../components/NavBar';
import { WelcomeCard } from '../../components/WelcomeCard';

export const Landing = () => {
  return (
    <div className="min-h-screen bg-brand-900">
      {/* <div className="mx-[140px]"> */}
        <NavBar />
      {/* </div> */}
      <WelcomeCard />
      <Footer />
    </div>
  );
};

