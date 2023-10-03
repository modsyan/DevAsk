import { Comment } from './comment.type';
import { Solution } from './solution.type';
import { User } from './user.type';

export interface Question {
  id: string;
  user: User;
  title: string;
  content: string;
  votes: User[];
  createdAt: Date;
}

export interface QuestionDetail extends Question {
  solutions: Solution[];
  comments: Comment[];
  updatedAt: Date;
}
