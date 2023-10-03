// import { Question, QuestionBox } from "@features/questions/QuestionBox"
import Skeleton from "react-loading-skeleton"



export const SkeletonLoading: React.FC = () => {
  return (<>
      <Skeleton count={4}/>
  </>)
}