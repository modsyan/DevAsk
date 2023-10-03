import { UserDetail } from "./user.type";

export interface LoginRequestDto {
  login: string;
  password: string;
}

export interface RegisterRequestDto {
  firstName: string;
  lastName: string;
  password: string;
  username: string;
  email: string;
  bio: string;
}

export interface AuthResponseDto {
  user: UserDetail;
  token: string;
  refreshToken: string;
}