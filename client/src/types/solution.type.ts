import { Comment } from './comment.type';
import {Question} from './question.types'
import { User } from './user.type';

export interface Solution{
  id: string;
  user: User;
  title: string;
  content: string;
  comments: Comment[];
  votes: User[];
  createdAt: Date;
  updatedAt: Date;
}

export interface SolutionDetail extends Solution {
  question: Question;
}