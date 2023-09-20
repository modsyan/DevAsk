import { Link } from "react-router-dom";

export const Logo = () => {
  return (
    <>
      <Link to={'/'}>
        <h1 className={['text-zinc-300', 'font-extrabold'].join(' ')}>
          DevAsk
        </h1>
      </Link>
    </>
  );
};