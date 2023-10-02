export type RegisterUserRequest = {
  firstName: string;
  lastName: string;
  password: string;
  bio: string;
};
export type RegisterUserResponse = {
  message: string;
  data: {
    user: RegisterUserRequest;
    token: string;
    refreshToken: string;
  };
};
