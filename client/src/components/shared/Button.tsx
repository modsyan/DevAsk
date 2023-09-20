import { MouseEventHandler } from "react";

const buttonConfig = {
  solid: `bg-brand-7000 hover:bg-brand-800 text-zinc-50 text-center p-2 rounded-md text-sm`,
  ghost: `hover:bg-brand-800 text-zinc-50 text-center p-2 rounded-md text-sm`,
};

const buttonSize = {
  sm: `w-[100px] h-[40px]`,
  md: `w-[180px] h-[40px]`,
  lg: `w-[240px] h-[40px]`,
  xl: `w-[300px] h-[40px]`,
};

export interface ButtonProps {
  id?: number;
  label: string;
  variant?: "solid" | "ghost";
  size?: "sm" | "md" | "lg" | "xl";
  onClick?: MouseEventHandler<HTMLButtonElement>;
}

export const Button: React.FC<ButtonProps> = ({
  label = "Button",
  variant = "solid",
  size = "lg",
  onClick = () => {
    console.log("Clicked Button");
  },
}) => {
  const className: string = [
    `${buttonConfig[variant]}`,
    `${buttonSize[size]}`,
    "transition-all",
    "duration-500",
    "ease-in-out",
    "flex",
    "justify-center",
    "items-center gap-3",
  ].join(" ");

  return (
    <>
      <button className={className} onClick={onClick}>
        {label}
      </button>
    </>
  );
};
