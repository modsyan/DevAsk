import { Link } from 'react-router-dom';

export const WelcomeCard = () => {
  return (
    <div
      className={[
        'min-h-screen',
        'flex',
        'items-center',
        'justify-center',
        'gap-8',
      ].join(' ')}
    >
      <div className={['prose', 'py-8', 'px-4', 'rounded-xl'].join(' ')}>
        <div
          className={[
            'w-[200px]',
            'h-[200px]',
            'bg-indigo-600',
            'rounded-full',
            'absolute',
            'opacity-20',
            '-translate-x-20',
            '-translate-y-10',
            'blur-md',
          ].join(' ')}
          ></div>

        <h3 className="text-yellow-100">Have your DevAsk Now</h3>
        <h1 className="text-zinc-50 text-7xl">Welcome to DevAsk Platform</h1>
        <p className="text-zinc-400">
          At DevAsk, we understand the challenges developers face when it comes
          to tackling software bugs. That's why we've developed a revolutionary
          platform to streamline the entire bug-solving process and empower
          developers like you.
        </p>
        <Link to={'/questions'}>
          <button
            className={[
              'bg-brand-700',
              'px-3',
              'py-2',
              'rounded-md',
              'text-zinc-100',
              'font-medium',
              'hover:text-zinc-300',
              'transition-all',
              'ease-in-out',
              'duration-200',
            ].join(' ')}
          >
            View Questions
          </button>
        </Link>
      </div>
    </div>
  );
};
