import { Question } from '@features/questions/QuestionBox';
import { Solution } from './solution.type';

export interface User {
  id: string;
  firstName: string;
  lastName: string;
  username: string;
  email: string;
  bio: string;
  profilePicture: string;
}

export interface UserDetail extends User {
  questions: Question[];
  solutions: Solution[];
  role: string[];
  createdAt: Date;
  updatedAt: Date;
}
