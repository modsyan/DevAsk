import { motion } from 'framer-motion';
import { StyledDiv } from './spinner.styled';

export const Spinner = () => {
  return (
    <StyledDiv>
      <motion.div className="w-[200px] h-[200px] bg-brand-600" />
    </StyledDiv>
  );
};
