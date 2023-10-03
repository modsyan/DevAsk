import React from 'react';
import { AiFillWarning } from 'react-icons/ai';

export const NotFound: React.FC = () => {
  return (
    <>
      <div className="gap-1 bg-brand-600 justify-center h-screen flex items-center">
        <div className="py-32 px-20 bg-red-800 rounded-xl flex flex-row items-center gap-3">
          <AiFillWarning size={44} color="white" />
          <span className="text-blue-50 font-bold font-poppins text-4xl  ">
            Can not fetch data !
          </span>
        </div>
      </div>
    </>
  );
};
