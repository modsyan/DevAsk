import { Link } from "react-router-dom";
import { Button } from "../shared/Button";

export const AuthButtons = () => {
  return (
    <div className="flex gap-3">
      <Link to={'/login'}>
        <Button label="Login" variant="ghost" size="sm" />
      </Link>

      <Link to={'/register'}>
        <Button label="Register" variant="solid" size="sm" />
      </Link>
    </div>
  );
};