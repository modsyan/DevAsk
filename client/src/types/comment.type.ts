import { User } from './user.type';

export interface Comment {
  id: string;
  User: User;
  Content: string;
  createdAt: Date;
  updatedAt: Date;
}
