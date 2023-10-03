// import { motion } from 'framer-motion';
import { StyledDiv } from './spinner.styled';

export const Spinner = () => {
  return (
    <StyledDiv>
      {/* <motion.div className="w-[200px] h-[200px] bg-brand-600" /> */}
        <div className="absolute right-1/2 bottom-1/2  transform translate-x-1/2 translate-y-1/2 ">
          <div className="border-t-transparent border-solid animate-spin  rounded-full border-blue-400 border-8 h-64 w-64"></div>
        </div>
    </StyledDiv>
  );
};
